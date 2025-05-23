<script setup lang="ts">
import EditorJS from '@editorjs/editorjs';
import Header from '@editorjs/header';
import List from '@editorjs/list';
import {ref, onMounted, onBeforeUnmount, inject} from 'vue';
import { useRoute, useRouter } from 'vue-router';
import BackendApiUtils from '@/api/BackendApi';

const route = useRoute();
const router = useRouter();

const toast = inject('toast');
const title = ref('');
let editor: EditorJS | null = null;

async function loadResume(id: string) {
    try {
        const response = await BackendApiUtils.Resume.get(+id);
        title.value = response.data.name || '';
        if (response.data.text) {
            return JSON.parse(response.data.text);
        }
    } catch (e) {
        console.error('Ошибка загрузки резюме', e);
    }
}

async function saveResume() {
    if (!editor) return;

    try {
        const content = await editor.save();
        console.log(content);
        console.log(route.params.id)
        const data = {
            id: route.params.id ? route.params.id : undefined,
            name: title.value,
            text: JSON.stringify(content),
        };
        if (data.id) {
            await BackendApiUtils.Resume.update(data);
        } else {
            await BackendApiUtils.Resume.create(data);
        }
        router.push('/resume');
        toast?.value?.showToast('Резюме успешно сохранено!', 'success');
    } catch (e) {
        console.log(e)
        toast?.value?.showToast(e.response.data.message, 'danger');
        console.error('Ошибка сохранения резюме', e);
    }
}

onMounted(async () => {
    let text = '';
    if (route.params.id) {
        text = await loadResume(route.params.id as string);
    }
    editor = new EditorJS({
        holder: 'editorjs',
        placeholder:
            'Опишите ваш опыт работы. Нажав на иконку +, вы можете добавлять блоки текста, заголовки и списки.',
        data: text,
        tools: {
            header: {
                class: Header as any,
                config: {
                    placeholder: 'Напишите заголовок',
                    levels: [4, 5],
                    defaultLevel: 4,
                },
            },
            list: {
                class: List as any,
                inlineToolbar: true,
                config: {
                    defaultStyle: 'unordered',
                },
            },
        },
        i18n: {
            messages: {
                ui: {
                    blockTunes: {
                        toggler: {
                            'Click to tune': 'Нажмите, чтобы настроить',
                            'or drag to move': 'или перетащите',
                        },
                    },
                    inlineToolbar: {
                        converter: {
                            'Convert to': 'Изменить блок',
                        },
                    },
                    toolbar: {
                        toolbox: {
                            Add: 'Добавить',
                            Filter: 'Фильтр',
                        },
                    },
                },
                toolNames: {
                    Text: 'Обычный текст',
                    Heading: 'Заголовок',
                    List: 'Список',
                    Image: 'Изображение',
                    Bold: 'Полужирный',
                    Italic: 'Курсив',
                    InlineCode: 'Моноширинный',
                },
                blockTunes: {
                    delete: {
                        Delete: 'Удалить',
                    },
                    moveUp: {
                        'Move up': 'Переместить вверх',
                    },
                    moveDown: {
                        'Move down': 'Переместить вниз',
                    },
                },
            },
        },
    });
});

onBeforeUnmount(() => {
    editor?.destroy();
});
</script>

<template>
    <h1>Редактор резюме</h1>
    <div class="row mt-4">
        <div class="col-lg-7 col-12">
            <div class="box d-flex mb-4 flex-column">
                <h4>Название резюме</h4>
                <input
                    v-model="title"
                    class="input"
                    placeholder="Например, Junior Java разработчик"
                />
            </div>
            <div class="box d-flex justify-content-center flex-column mb-4">
                <h4>Текст резюме</h4>
                <div id="editorjs" class="input"></div>
            </div>
            <div class="d-flex">
                <a href="#" @click.prevent="saveResume" class="primary-button me-2">Сохранить</a>
                <router-link to="/resume" class="tertiary-button">Назад</router-link>
            </div>
        </div>
    </div>
</template>