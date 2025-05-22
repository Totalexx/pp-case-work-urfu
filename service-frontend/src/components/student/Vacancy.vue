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
                <a href="" class="primary-button">Откликнуться</a>
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
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import BackendApiUtils from '@/api/BackendApi'

const route = useRoute()
const vacancy = ref<any>(null)

onMounted(async () => {
    try {
        const id = route.params.id
        const response = await BackendApiUtils.Vacancy.get(id)
        vacancy.value = response.data
    } catch (e) {
        console.error('Ошибка загрузки вакансии', e)
    }
})
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