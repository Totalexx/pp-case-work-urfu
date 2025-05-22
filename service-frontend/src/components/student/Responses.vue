<template>
    <h1>Мои отклики</h1>
    <div class="row mt-4">
        <div class="col-7" v-for="response in responses" :key="response.id">
            <div class="box d-flex mb-3 flex-column">
                <div class="w-100">
                    <span
                        class="notification-status mb-2"
                        :class="{
                            'response-status_awaiting': response?.status === 'AWAITING',
                            'response-status_invitation': response.status === 'INVITATION',
                            'response-status_discard': response.status === 'DISCARD'
                        }"
                    >
                        {{
                            response.status === 'AWAITING'
                                ? 'В ожидании'
                                : response.status === 'INVITATION'
                                    ? 'Приглашение'
                                    : 'Отклонён'
                        }}
                    </span>
                    <h2 class="vacancy-title mb-3 mt-0">{{ response.title || '—' }}</h2>
                    <p class="mb-1 vacancy-salary">{{ response.salary !== null ? response.salary + '₽' : '—' }}</p>
                    <p class="mb-1">{{ response.company?.name || '—' }}</p>
                    <p>{{ response.location || '—' }}</p>
                    <p class="mb-4">{{ response.description || '—' }}</p>
                </div>
                <div class="d-flex">
                    <a class="secondary-button me-2" title="Чат">
                        <i class="bi bi-chat-dots m-1"></i> Чат
                    </a>
                    <a class="tertiary-button" title="Удалить" @click.prevent="deleteResponse(response.id)">
                        <i class="bi bi-trash m-1"></i>Удалить отклик
                    </a>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import BackendApiUtils from '@/api/BackendApi.ts'

const responses = ref([])

async function load() {
    const res = await BackendApiUtils.Vacancy.getAllResponses()
    responses.value = res.data.responses || []
}

async function deleteResponse(id: number) {
    await BackendApiUtils.Vacancy.deleteResponse(id)
    await load()
}

onMounted(load)
</script>

<style>
.notification-status {
    display: inline-flex;
    padding: 8px 16px;
    border-radius: 1000px;
}

.response-status_awaiting {
    color: #000000E6;
    background-color: #0000000D;
}

.response-status_invitation {
    color: #306F1C;
    background-color: #D7EFCC;
}

.response-status_discard {
    color: #875A15;
    background-color: #F5E9C9;
}
</style>