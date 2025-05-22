<template>
    <router-link to="/" class="tertiary-button mb-3" style="width: max-content;">
        ← Назад
    </router-link>
    <div class="row gap-3 align-content-start">
        <div class="col-7">
            <div class="box">
                <h1 class="mb-3">{{ vacancy?.title }}</h1>
                <p class="vacancy-salary mb-2">{{ vacancy?.salary }}₽</p>
                <p class="mb-1">{{ vacancy?.workingHours }} часов в день</p>
                <p>{{ vacancy?.location }}</p>
                <a href="" class="primary-button" @click.prevent="openModal">Откликнуться</a>
            </div>
            <div class="box mt-4">
                <h3 class="mb-3">Описание вакансии</h3>
                <p class="mb-2">{{ vacancy?.description }}</p>
            </div>
        </div>
        <div class="col-3 box company-info">
            <h3>{{ vacancy?.company?.name }}</h3>
            <div class="company-info_rating">
                4.5 <span style="color: #fdd53f; font-size: 20px;">★ ★ ★ ★ ☆</span><span class="company-info_rating-count">20 отзывов</span>
            </div>
        </div>
    </div>

    <ResumeSelectModal v-if="showModal" @selected="sendResponse" @close="closeModal" />
</template>

<script setup lang="ts">
import {ref, onMounted, inject} from 'vue'
import { useRoute } from 'vue-router'
import BackendApiUtils from '@/api/BackendApi'
import ResumeSelectModal from '@/components/util/ResumeSelectModal.vue'

const route = useRoute()
const toast = inject('toast');
const vacancy = ref<any>(null)
const showModal = ref(false)

onMounted(async () => {
    try {
        const id = route.params.id
        const response = await BackendApiUtils.Vacancy.get(id)
        vacancy.value = response.data
    } catch (e) {
        console.error('Ошибка загрузки вакансии', e)
    }
})

function openModal() {
    showModal.value = true
}

function closeModal() {
    showModal.value = false
}

async function sendResponse(resumeId: number) {
    showModal.value = false
    await BackendApiUtils.Vacancy.addResponse({
        resumeId,
        vacancyId: vacancy.value.id
    }).then(
        () => {
            toast?.value?.showToast('Отклик отправлен!', 'success')
        }
    ).catch((e) => {
        console.error('Ошибка отправки отклика', e)
        toast?.value?.showToast(e.response.data.message, 'danger')
    })
}
</script>

<style scoped>
.company-info {
    height: fit-content;
}

.company-info_rating {
    font-size: 20px;
}

.company-info_rating-count {
    font-size: 16px;
    margin-left: 14px;
}
</style>