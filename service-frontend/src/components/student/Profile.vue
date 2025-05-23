<template>
    <h1>Профиль</h1>
    <div class="row mt-4">
        <div class="col-lg-7 col-12">
            <div class="box d-flex mb-3 flex-column">
                <div class="d-flex align-items-center mb-3">
                    <img
                        class="profile-photo me-3"
                        src="https://ui-avatars.com/api/?name=Иванов+Иван+Иванович&background=0D8ABC&color=fff&size=96"
                        alt="Фото профиля"
                        width="64"
                        height="64"
                        style="border-radius: 50%; object-fit: cover;"
                    />
                    <div>
                        <div class="fw-bold fs-5">Иванов Иван Иванович</div>
                        <button class="secondary-button p-2 mt-2" title="Редактировать профиль">
                            <i class="bi bi-pencil m-1"></i> Редактировать
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">

</script>

<style scoped>
    .profile-photo {
        border-radius: 50%;
        object-fit: cover;
        width: 64px;
        height: 64px;
    }
</style>