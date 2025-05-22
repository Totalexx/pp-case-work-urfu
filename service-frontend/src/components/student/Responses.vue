<template>
    <h1>Мои отклики</h1>
    <div class="row mt-4">
        <div class="col-7">
            <div class="box d-flex mb-3 flex-column">
                <div class="w-100">
                    <span class="notification-status response-status_awaiting mb-2">В ожидании</span>
                    <h2 class="vacancy-title mb-3 mt-0">Специалист по разработке программного комплекса для управления МРТ</h2>
                    <p class="mb-1 vacancy-salary">120 000₽</p>
                    <p class="mb-1">ООО Научный подход</p>
                    <p>Ростов-на-Дону</p>
                    <p class="mb-4">
                        Участвовать в разработке нового Android-приложения с нуля на языке Java. Реализовывать пользовательский интерфейс на основе готовых макетов в Figma.
                        Базовые знания языка программирования Java. Понимание основных принципов разработки под Android. Знакомство с основами UI/UX дизайна и умение работать...
                    </p>
                </div>
                <div class="d-flex">
                    <a class="secondary-button me-2" title="Чат">
                        <i class="bi bi-chat-dots m-1"></i> Чат
                    </a>
                    <a class="tertiary-button" title="Удалить">
                        <i class="bi bi-trash m-1"></i>Удалить отклик
                    </a>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">

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