<template>
    <div class="toast-container position-fixed top-0 end-0 p-3" style="z-index: 1100">
        <div
            v-for="(toast, index) in toasts"
            :key="index"
            class="toast align-items-center text-#0033cc bg-{{ toast.variant }} border-0 show mb-2"
            role="alert"
            aria-live="assertive"
            aria-atomic="true"
        >
            <div class="d-flex">
                <div class="toast-body color-danger-500">
                    {{ toast.message }}
                </div>
                <button
                    type="button"
                    class="btn-close btn-close-white me-2 m-auto"
                    data-bs-dismiss="toast"
                    aria-label="Close"
                    @click="removeToast(index)"
                ></button>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';

interface Toast {
    message: string;
    variant: string;
}

const toasts = ref<Toast[]>([]);

function showToast(message: string, variant: string = 'primary') {
    toasts.value.push({ message, variant });
    setTimeout(() => {
        toasts.value.shift();
    }, 5000);
}

function removeToast(index: number) {
    toasts.value.splice(index, 1);
}

defineExpose({ showToast });
</script>

<style scoped>
.toast-container {
    z-index: 1100;
}
</style>