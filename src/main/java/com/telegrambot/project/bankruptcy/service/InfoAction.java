package com.telegrambot.project.bankruptcy.service;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static com.telegrambot.project.bankruptcy.Application.replyKeyboardMarkupBuilder;

public class InfoAction implements Actions {

    private final String action;
    public InfoAction(String action) {
        this.action = action;
    }

    @Override
    public BotApiMethod handle(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        String text = """
                Юридическая компания «ЭЛЬПИН» — современное решение в сфере банкротства физических лиц! Основная цель нашей компании – помочь Вам пройти процедуру банкротства (списания долгов) максимально быстро и комфортно. Для этого мы предлагаем ряд технологичных решений, одним из которых является данный чат-бот Дмитрий.

                Задавайте ему вопросы, подавайте документы и выбирайте арбитражного управляющего. Он создан, чтобы подарить Вам свободу!""";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(initKeyBoard());
        return sendMessage;
    }

    @Override
    public BotApiMethod callback(Update update) {
        return handle(update);
    }

    public static ReplyKeyboardMarkup initKeyBoard() {

        ReplyKeyboardMarkup keyboardMarkup = replyKeyboardMarkupBuilder();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);
        keyboardRow.add(new KeyboardButton("Вернуться назад"));
        keyboardRow.add(new KeyboardButton("Задать вопрос юристу"));

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }
}
