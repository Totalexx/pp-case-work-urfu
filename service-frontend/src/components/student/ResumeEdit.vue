<template>
    <h1>Редактор резюме</h1>
    <div class="row mt-4">
        <div class="col-7">
            <div class="box d-flex mb-4 flex-column">
                <h4>Название резюме</h4>
                <input class="input" placeholder="Например, Junior Java разработчик">
            </div>
            <div class="box d-flex justify-content-center flex-column mb-4">
                <h4>Текст резюме</h4>
                <div id="editorjs" class="input"></div>
            </div>
            <div class="d-flex">
                <a href="" class="primary-button me-2">Сохранить</a>
                <router-link to="/resume" class="tertiary-button">
                    Назад
                </router-link>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
    import EditorJS from '@editorjs/editorjs';
    import Header from '@editorjs/header';
    import List from '@editorjs/list';
    import {nextTick, onBeforeUnmount, onMounted} from "vue";

    let editor: EditorJS | null = null

    onMounted(() => {
        editor = new EditorJS({
            holder: 'editorjs',
            placeholder: 'Опишите ваш опыт работы. ' +
                'Нажав на иконку +, вы можете добавлять блоки текста, заголовки и списки.',
            tools: {
                header: {
                    class: Header as any,
                    config: {
                        placeholder: 'Напишите заголовок',
                        levels: [4, 5],
                        defaultLevel: 4
                    }
                },
                list: {
                    class: List as any,
                    inlineToolbar: true,
                    config: {
                        defaultStyle: 'unordered'
                    }
                },
            },
            i18n: {
                messages: {
                    ui: {
                        "blockTunes": {
                            "toggler": {
                                "Click to tune": "Нажмите, чтобы настроить",
                                "or drag to move": "или перетащите"
                            },
                        },
                        "inlineToolbar": {
                            "converter": {
                                "Convert to": "Изменить блок"
                            }
                        },
                        "toolbar": {
                            "toolbox": {
                                "Add": "Добавить",
                                "Filter": "Фильтр",
                            }
                        }
                    },
                    toolNames: {
                        "Text": "Обычный текст",
                        "Heading": "Заголовок",
                        "List": "Список",
                        "Image": "Изображение",
                        "Bold": "Полужирный",
                        "Italic": "Курсив",
                        "InlineCode": "Моноширинный",
                    },
                    tools: {
                    },
                    blockTunes: {
                        "delete": {
                            "Delete": "Удалить"
                        },
                        "moveUp": {
                            "Move up": "Переместить вверх"
                        },
                        "moveDown": {
                            "Move down": "Переместить вниз"
                        }
                    },
                }
            }
        })
    })

    onBeforeUnmount(() => {
        editor?.destroy()
    })
</script>

<style>

</style>