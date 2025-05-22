<template>
    <ResumeSelectModal v-if="selectedVacancyId" @selected="respondToVacancy" @close="selectedVacancyId = null" />
    <h1 class="mb-4">Вакансии</h1>
    <div class="row vacancy-search-container align-content-start">
        <div class="vacancy-container col-8">
            <div v-for="vacancy in vacancies" :key="vacancy.id" class="vacancy box">
                <h2 class="vacancy-title mb-3 mt-0">{{ vacancy.title }}</h2>
                <p class="mb-1 vacancy-salary">{{ vacancy.salary }}₽</p>
                <p class="mb-1">{{ vacancy.company.name }}</p>
                <p>{{ vacancy.location }}</p>
                <p class="mb-4">{{ vacancy.description }}</p>
                <a class="primary-button me-2" @click="openResumeSelect(vacancy.id)">Откликнуться</a>
                <router-link :to="`/vacancy/${vacancy.id}`" class="secondary-button mb-1">Подробнее</router-link>
            </div>
        </div>
        <div class="vacancy-filter col-3">
            <div class="box mb-3">
                <h5 class="mb-3 fw-bold">Фильтр вакансий</h5>
                <div class="mb-3">
                    <label for="filter-title" class="form-label fw-normal">Название</label>
                    <input id="filter-title" v-model="filterTitle" type="text" class="input" placeholder="Например, Java" />
                </div>
                <div class="mb-3">
                    <div class="d-flex gap-2">
                        <div>
                            <label for="filter-salary" class="form-label fw-normal">Зарплата от</label>
                            <input id="filter-salary" v-model="filterSalary" type="number" class="input" placeholder="от" />
                        </div>
                        <div>
                            <label for="filter-salary-to" class="form-label fw-normal">Зарплата до</label>
                            <input id="filter-salary-to" v-model="filterSalaryTo" type="number" class="input" placeholder="до" />
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="filter-location" class="form-label fw-normal">Локация</label>
                    <input id="filter-location" v-model="filterLocation" type="text" class="input" placeholder="Екатеринбург" />
                </div>
                <a class="primary-button w-100" @click="applyFilter">Применить</a>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import {ref, onMounted, inject} from 'vue';
import ResumeSelectModal from '@/components/util/ResumeSelectModal.vue';
import BackendApiUtils from '@/api/BackendApi.ts';
const toast = inject('toast');

const vacancies = ref([]);
const filterTitle = ref('');
const filterSalary = ref('');
const filterSalaryTo = ref('');
const filterLocation = ref('');
const selectedVacancyId = ref<number | null>(null);

async function loadVacancies() {
    const filter = {
        title: filterTitle.value,
        minSalary: filterSalary.value ? Number(filterSalary.value) : undefined,
        maxSalary: filterSalaryTo.value ? Number(filterSalaryTo.value) : undefined,
        locationStarts: filterLocation.value,
    };

    const response = await BackendApiUtils.Vacancy.getAll(filter).catch(
        (e) => {
            toast?.value?.showToast(e.response.data.message, 'danger');
        }
    );
    vacancies.value = response.data.vacancies;
}

onMounted(loadVacancies);

function applyFilter() {
    loadVacancies();
}

function openResumeSelect(vacancyId: number) {
    selectedVacancyId.value = vacancyId;
}

async function respondToVacancy(resumeId: number) {
    if (!selectedVacancyId.value) return;
    await BackendApiUtils.Vacancy.addResponse({ vacancyId: selectedVacancyId.value, resumeId: resumeId })
        .then(() => {
            loadVacancies();
            toast?.value?.showToast('Отклик отправлен!', 'success');
        }).catch((e) => {
            toast?.value?.showToast(e.response.data.message, 'danger');
        });
    selectedVacancyId.value = null;
}
</script>

<style scoped>
.vacancy-search-container {
    height: 100vh;
}

.vacancy-filter {
    height: fit-content;
    position: sticky;
    top: 16px;
}

.vacancy {
    margin-bottom: 24px;
}

.vacancy-title {
    font-weight: bold;
}

.vacancy-salary {
    font-size: 22px;
}
</style>