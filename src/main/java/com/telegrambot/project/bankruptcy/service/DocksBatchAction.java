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

public class DocksBatchAction implements Actions {

    public final String action;

    public DocksBatchAction(String action) {
        this.action = action;
    }

    @Override
    public BotApiMethod handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = "Пожалуйста, укажите ваше ФИО и номер договора";
        return new SendMessage(chatId, text);
    }

    @Override
    public BotApiMethod callback(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = "Спасибо! Теперь я буду называть документ, а Вы будете направлять его в чат. " +
                "Пожалуйста прикрепляйте запрашиваемые документы в формате PDF! Вы готовы?";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(initReplyMarkup());
        return sendMessage;
    }

    public static ReplyKeyboardMarkup initReplyMarkup() {
        ReplyKeyboardMarkup keyboardMarkup = replyKeyboardMarkupBuilder();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);

        keyboardRow.add(new KeyboardButton("Готов"));
        keyboardRow.add(new KeyboardButton("Вернуться назад"));

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }
}
