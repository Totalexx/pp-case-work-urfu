<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import BackendApiUtils from '@/api/BackendApi';

interface Resume {
    id: number;
    title: string;
    description: string;
}

const resumes = ref<Resume[]>([]);
const router = useRouter();

async function loadResumes() {
    try {
        const response = await BackendApiUtils.Resume.getAll();
        resumes.value = response.data.resumes;
        console.log(response);
    } catch (e) {
        console.error('Ошибка загрузки резюме', e);
    }
}

async function deleteResume(id: number) {
    if (!confirm('Вы действительно хотите удалить резюме?')) return;
    try {
        await BackendApiUtils.Resume.delete(id);
        resumes.value = resumes.value.filter(r => r.id !== id);
    } catch (e) {
        console.error('Ошибка удаления резюме', e);
    }
}

onMounted(() => {
    loadResumes();
});
</script>

<template>
    <h1>Мои резюме</h1>
    <div class="row mt-4">
        <div class="col-7">
            <div
                v-for="resume in resumes"
                :key="resume.id"
                class="box d-flex justify-content-between align-items-center mb-3"
            >
                <div>
                    <span class="fs-5 fw-bold">{{ resume.name }}</span>
                </div>
                <div>
                    <router-link :to="`/resume/edit/${resume.id}`" class="secondary-button me-2" title="Редактировать">
                        <i class="bi bi-pencil"></i>
                    </router-link>
                    <a @click.prevent="deleteResume(resume.id)" class="tertiary-button" title="Удалить">
                        <i class="bi bi-trash"></i>
                    </a>
                </div>
            </div>

            <router-link to="/resume/create">
                <div class="resume-block d-flex justify-content-center align-items-center primary-button">
                    +
                </div>
            </router-link>
        </div>
    </div>
</template>