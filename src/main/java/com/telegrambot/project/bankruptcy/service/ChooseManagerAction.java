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

public class ChooseManagerAction implements Actions {

    public final String action;
    public ChooseManagerAction(String action) {
        this.action = action;
    }

    @Override
    public BotApiMethod handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = "Сейчас я помогу Вам выбрать лучшего арбитражного управляющего! " +
                "Но сначала нам нужно будет заполнить небольшую анкету. Если готовы, нажмите \"Заполнить\"";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(initReplyMarkup());
        return sendMessage;
    }

    @Override
    public BotApiMethod callback(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = "Команда не распознана. Пожалуйста, вернитесь к началу /start и повторите";
        return new SendMessage(chatId, text);
    }


    public static ReplyKeyboardMarkup initReplyMarkup() {
        ReplyKeyboardMarkup keyboardMarkup = replyKeyboardMarkupBuilder();
        keyboardMarkup.setIsPersistent(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);

        keyboardRow.add(new KeyboardButton("Заполнить"));
        keyboardRow.add(new KeyboardButton("Вернуться назад"));

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }
}
