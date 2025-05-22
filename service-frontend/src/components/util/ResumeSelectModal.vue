<template>
    <div class="modal-backdrop">
        <div class="modal-content box">
            <h3 class="mb-3">Выберите резюме</h3>
            <select v-model="selectedId" class="input mb-3">
                <option disabled value="">— Выберите резюме —</option>
                <option v-for="resume in resumes" :key="resume.id" :value="resume.id">
                    {{ resume.name }}
                </option>
            </select>
            <a class="primary-button w-100 mb-2" @click="submit">Выбрать</a>
            <a class="secondary-button w-100" @click="$emit('close')">Отмена</a>
        </div>
    </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import BackendApiUtils from '@/api/BackendApi.ts';

const resumes = ref([]);
const selectedId = ref('');
const emit = defineEmits(['selected', 'close']);

onMounted(async () => {
    const response = await BackendApiUtils.Resume.getAll();
    resumes.value = response.data.resumes;
});

function submit() {
    if (selectedId.value) emit('selected', +selectedId.value);
}
</script>

<style scoped>
.modal-backdrop {
    position: fixed;
    inset: 0;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 1000;
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal-content {
    background: white;
    padding: 24px;
    border-radius: 12px;
    width: 400px;
}
</style>