<template>
    <router-view/>
</template>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap');
    * {
        font-family: 'Open Sans', sans-serif;
        margin: 0;
        padding: 0;
    }

    body {
        background-color: #fafafa;
        color: #181818;
    }

    body a {
        text-decoration: none;
    }

    .box {
        background-color: #fff;
        box-shadow: rgba(0, 0, 0, 0.07) 0px 1px 6px 0px;
        border-radius: 16px;
        padding: 18px 22px;
    }

    .input {
        width: 100%;
        background-color: #F5F5F7;
        border: none;
        border-radius: 28px;
        padding: 14px 44px 14px 24px;

        color: #000000E6;
        font-size: 18px;
        font-weight: 400;
        line-height: 120%;
    }

    .input::placeholder {
        color: #00000081;
    }

    .input:focus {
        outline-color: #F75700FF;
        outline-width: 3px;
    }

    .primary-button {
        display: inline-flex;
        align-items: center;
        justify-content: center;
        text-align: center;

        cursor: pointer;
        background-color: #22B6A9;
        padding: 12px 24px;
        border: none;
        border-radius: 100px;

        color: #FFFFFF;
        font-size: 18px;
        font-weight: 500;
        line-height: 120%;

        transition: all 0.2s ease-out;
    }

    .primary-button:hover {
        background-color: #28A297;
        transition: all 0.2s ease-out;
    }

    .primary-button_disabled {
        background: #22B6A9;
        opacity: 0.5;
    }

    .primary-button:focus {
        outline: 3px solid #F75700FF;
    }

    .secondary-button {
        display: inline-flex;
        align-items: center;
        justify-content: center;
        text-align: center;

        cursor: pointer;
        background-color: #DFF3F2;
        padding: 12px 24px;
        border: none;
        border-radius: 100px;

        color: #127A71;
        font-size: 18px;
        font-weight: 500;
        line-height: 120%;

        transition: all 0.2s ease-out;
    }

    .secondary-button:hover {
        background-color: #CDE6E5;
        transition: all 0.2s ease-out;
    }

    .secondary-button_disabled {
        background: #DFF3F2;
        opacity: 0.5;
    }

    .secondary-button:focus {
        outline: 3px solid #F75700FF;
    }

    .tertiary-button {
        display: inline-flex;
        align-items: center;
        justify-content: center;
        text-align: center;

        cursor: pointer;
        background-color: #00000014;
        padding: 12px 24px;
        border: none;
        border-radius: 100px;

        color: #000000E6;
        font-size: 18px;
        font-weight: 500;
        line-height: 120%;

        transition: all 0.2s ease-out;
    }

    .tertiary-button:hover {
        background-color: #00000026;
        transition: all 0.2s ease-out;
    }

    .tertiary-button_disabled {
        background: #00000026;
        opacity: 0.5;
    }

    .tertiary-button:focus {
        outline: 3px solid #F75700FF;
    }

</style>
