<template>
    <h1>Мои резюме</h1>
    <div class="row mt-4">
        <div class="col-7">
            <div class="box d-flex justify-content-between align-items-center mb-3">
                <div>
                    <span class="fs-5 fw-bold">Java разработчик</span>
                    <div class="text-muted small mt-1">Опыт работы с Vue.js, JavaScript, создание SPA, участие в командных проектах...</div>
                </div>
                <div>
                    <router-link to="/resume/edit/123" class="secondary-button me-2" title="Редактировать">
                        <i class="bi bi-pencil"></i>
                    </router-link>
                    <a class="tertiary-button" title="Удалить">
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

<script setup lang="ts">

</script>

<style>

</style>