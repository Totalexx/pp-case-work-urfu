<template>
    <h1>Уведомления</h1>
    <div class="row mt-4">
        <div class="col-lg-7 col-12">
            <div class="box d-flex mb-3 flex-column">
                <span class="fs-5 mb-1">
                    Вам пришло новое приглашение
                    <span class="notification-status notification-status_new ms-2">Новое</span>
                </span>
                <span class="text-muted small">12.06.2024 14:06</span>
            </div>
            <div class="box d-flex mb-3 flex-column">
                <span class="fs-5 mb-1">Ваш отклик рассмотрен</span>
                <span class="text-muted small">10.06.2024 12:20</span>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">

</script>

<style>
    .notification-status {
        display: inline-flex;
        padding: 2px 8px;
        font-size: 16px;
        border-radius: 1000px;
    }

    .notification-status_new {
        color: #fff;
        background-color: #31b2ff;
    }
</style>