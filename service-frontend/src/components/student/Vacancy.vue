<template>
    <router-link to="/" class="tertiary-button mb-3" style="width: max-content;">
        ← Назад
    </router-link>
    <div class="row gap-3 align-content-start">
        <div class="col-7">
            <div class="box">
                <h1 class="mb-3">Java разработчик</h1>
                <p class="vacancy-salary mb-2">120 000₽</p>
                <p class="mb-1">8 часов в день</p>
                <p>Ростов-на-Дону</p>
                <a href="" class="primary-button">Откликнуться</a>
            </div>
            <div class="box mt-4">
                <h3 class="mb-3">Описание вакансии</h3>
                <p class="mb-2">
                    Участвовать в разработке нового Android-приложения с нуля на языке Java. Реализовывать пользовательский интерфейс на основе готовых макетов в Figma.
                </p>
                <h4>Требования</h4>
                <ul>
                    <li>Базовые знания языка программирования Java</li>
                    <li>Понимание основных принципов разработки под Android</li>
                    <li>Знакомство с основами UI/UX дизайна и умение работать с макетами</li>
                </ul>
            </div>
        </div>
        <div class="col-3 box company-info">
            <h3>ООО Веб Решения</h3>
            <div class="company-info_rating">
                4.5 <span style="color: #fdd53f; font-size: 20px;">★ ★ ★ ★ ☆</span><span class="company-info_rating-count">20 отзывов</span>
            </div>

        </div>
    </div>
</template>

<script setup lang="ts">

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