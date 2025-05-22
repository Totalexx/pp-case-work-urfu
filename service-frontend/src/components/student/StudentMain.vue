<template>
    <div class="container-fluid student-main">
        <div class="row">
            <div class="sidebar col-2">
                <div class="link-list">
                    <router-link to="/">
                        <div class="sidebar-link">
                            <span class="me-2 link-icon"><i class="bi bi-briefcase"></i></span>
                            Вакансии
                        </div>
                    </router-link>
                    <router-link to="/resume">
                        <div class="sidebar-link">
                            <span class="me-2 link-icon"><i class="bi bi-file-earmark-person"></i></span>
                            Резюме
                        </div>
                    </router-link>
                    <router-link to="/responses">
                        <div class="sidebar-link">
                            <span class="me-2 link-icon"><i class="bi bi-envelope-open"></i></span>
                            Отклики
                        </div>
                    </router-link>
                    <router-link to="/profile">
                        <div class="sidebar-link">
                            <span class="me-2 link-icon"><i class="bi bi-person"></i></span>
                            Профиль
                        </div>
                    </router-link>
                    <router-link to="/notifications">
                        <div class="sidebar-link">
                            <span class="me-2 link-icon"><i class="bi bi-bell"></i></span>
                            Уведомления
                        </div>
                    </router-link>
                    <div class="sidebar-link sidebar-link-logout">
                        <span class="me-2 link-icon"><i class="bi bi-door-open"></i></span>
                        Выйти
                    </div>
                </div>
            </div>
            <div class="main-content col-10">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap');
    * {
        font-family: 'Open Sans', sans-serif;
    }

    .student-main.container-fluid {
        padding: 40px 20px 20px;
    }

    .sidebar {
        padding-top: 40px;
        padding-right: 30px;
        padding-left: 20px;
    }

    .link-icon {
        padding: 5px 8px;
        background: #fff;
        border-radius: 8px;
        box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 6px 0px;
        color: #919191;
    }

    .link-icon i {
        display: inline-block;
        height: 16px;
        width: 16px;
    }

    .sidebar-link {
        border-radius: 8px;
        margin-bottom: 10px;
        padding: 16px;
    }

    .router-link-exact-active .sidebar-link {
        background-color: #fff;
        box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 6px 0px;
        font-weight: 700;
    }

    .router-link-exact-active .sidebar-link .link-icon {
        background-color: #22B6A9;
        color: #fff;
    }

    .sidebar-link-logout {
        margin-top: 14px;
        border-radius: 8px;
        margin-bottom: 10px;
        padding-top: 24px;
        border-top: 1px solid #e0e0e0;
    }

    .main-content {
        padding-left: 10px;
    }
</style>
<script setup lang="ts">
</script>