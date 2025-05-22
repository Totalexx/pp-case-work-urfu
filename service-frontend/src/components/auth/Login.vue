<script setup lang="ts">
</script>

<template>
<div class="container-fluid login-page-bg">
    <div class="row justify-content-center align-items-center min-vh-100">
        <div class="col-12 col-md-5 col-lg-3">
            <div class="box p-4">
                <h2 class="mb-4 text-center">Вход в систему</h2>
                <form>
                    <div class="mb-4">
                        <label for="email" class="form-label">Email</label>
                        <input id="email" type="email" class="input" placeholder="Введите email" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Пароль</label>
                        <input id="password" type="password" class="input" placeholder="Введите пароль" required>
                    </div>
                    <button type="submit" class="primary-button w-100 mt-3">Войти</button>
                </form>
            </div>
        </div>
    </div>
</div>
</template>

<style>
    .form-label {
        font-size: 20px;
        font-weight: 600;
    }
    .form-control {
        border-radius: 6px;
        font-size: 16px;
        padding: 8px 12px;
        border: 1px solid #ccc;
    }
</style>

