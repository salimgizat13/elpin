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

public class StartAction implements Actions {

    private final String action;


    public StartAction(String action) {
        this.action = action;
    }

    @Override
    public BotApiMethod handle(Update update) {

        var chatId = update.getMessage().getChatId().toString();
        StringBuilder text = new StringBuilder("""
                Добро пожаловать в бот Эльпин!

                Здесь Вы сможете получить квалифицированную помощь от юристов по банкротству!

                Выберите необходимую опцию:
                """);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text.toString());
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
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        keyboardRow.add(new KeyboardButton("О нас"));
        keyboardRow.add(new KeyboardButton("Задать вопрос юристу"));
        keyboardRow1.add(new KeyboardButton("Направить пакет документов"));
        keyboardRow2.add(new KeyboardButton("Выбрать арбитражного управляющего"));

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }

}
