<template>
    <h1 class="mb-4">Вакансии</h1>

    <div class="row vacancy-search-container align-content-start">
        <div class="vacancy-container col-8">
            <div class="vacancy box">
                <h2 class="vacancy-title mb-3 mt-0">Специалист по разработке программного комплекса для управления МРТ</h2>
                <p class="mb-1 vacancy-salary">120 000₽</p>
                <p class="mb-1">ООО Научный подход</p>
                <p>Ростов-на-Дону</p>
                <p class="mb-4">
                    Участвовать в разработке нового Android-приложения с нуля на языке Java. Реализовывать пользовательский интерфейс на основе готовых макетов в Figma.
                    Базовые знания языка программирования Java. Понимание основных принципов разработки под Android. Знакомство с основами UI/UX дизайна и умение работать...
                </p>
                <a href="" class="primary-button me-2">Откликнуться</a>
                <router-link to="/vacancy/123" class="secondary-button mb-1">Подробнее</router-link>
            </div>
            <div class="vacancy box ">
                <h2 class="vacancy-title mb-3 mt-0">Frontend-разработчик</h2>
                <p class="mb-1">ООО Веб Решения</p>
                <p>Москва</p>
                <p class="mb-4">
                    Разработка пользовательских интерфейсов на Vue.js. Интеграция с REST API. Оптимизация производительности веб-приложений.
                    Знание JavaScript, HTML, CSS. Опыт работы с Vue.js и понимание принципов SPA.
                </p>
                <a href="" class="primary-button me-2">Откликнуться</a>
                <a href="" class="secondary-button mb-1">Подробнее</a>
            </div>
            <div class="vacancy box ">
                <h2 class="vacancy-title mb-3 mt-0">Backend-разработчик</h2>
                <p class="mb-1">ООО Технологии Будущего</p>
                <p>Санкт-Петербург</p>
                <p class="mb-4">
                    Разработка серверной части приложений на Node.js. Проектирование и реализация REST API. Работа с базами данных (PostgreSQL, MongoDB).
                    Опыт работы с Node.js, знание TypeScript, понимание принципов работы с базами данных.
                </p>
                <a href="" class="primary-button me-2">Откликнуться</a>
                <a href="" class="secondary-button mb-1">Подробнее</a>
            </div>
            <div class="vacancy box ">
                <h2 class="vacancy-title mb-3 mt-0">UI/UX дизайнер</h2>
                <p class="mb-1">ООО Дизайн Лаб</p>
                <p>Екатеринбург</p>
                <p class="mb-4">
                    Создание макетов интерфейсов в Figma. Проведение исследований пользовательского опыта. Разработка дизайн-систем.
                    Опыт работы с Figma, знание основ UI/UX дизайна, умение работать с прототипами.
                </p>
                <a href="" class="primary-button me-2">Откликнуться</a>
                <a href="" class="secondary-button mb-1">Подробнее</a>
            </div>

        </div>
        <div class="vacancy-filter col-3">
            <div class="box mb-3">
                <h5 class="mb-3 fw-bold">Фильтр вакансий</h5>
                <div class="mb-3">
                    <label for="filter-title" class="form-label fw-normal">Название</label>
                    <input id="filter-title" v-model="filterTitle" type="text" class="input" placeholder="Например, Java">
                </div>
                <div class="mb-3">
                    <div class="d-flex gap-2">
                        <div>
                            <label for="filter-salary" class="form-label fw-normal">Зарплата от</label>
                            <input id="filter-salary" v-model="filterSalary" type="number" class="input" placeholder="от">
                        </div>
                        <div>
                            <label for="filter-salary-to" class="form-label fw-normal">Зарплата до</label>
                            <input id="filter-salary-to" v-model="filterSalaryTo" type="number" class="input" placeholder="до">
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="filter-location" class="form-label fw-normal">Локация</label>
                    <input id="filter-location" v-model="filterLocation" type="text" class="input" placeholder="Екатеринбург">
                </div>
                <a class="primary-button w-100" @click="applyFilter">Применить</a>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">

</script>

<style>
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