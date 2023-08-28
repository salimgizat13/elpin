package com.telegrambot.project.bankruptcy.service.dock_batches;

import com.telegrambot.project.bankruptcy.service.Actions;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static com.telegrambot.project.bankruptcy.Application.replyKeyboardMarkupBuilder;

public class DocksBatchAction16 implements Actions {

    public final String action;
    public DocksBatchAction16(String actions) {
        this.action = actions;
    }

    @Override
    public BotApiMethod handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = "Выписка из Национального бюро кредитных историй";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(initReplyMarkupA());
        return sendMessage;
    }

    @Override
    public BotApiMethod callback(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = EmojiParser.parseToUnicode("Отлично! Все документы приняты! Ваше заявление на подготовке у юристов. Я напишу Вам, когда заявление будет готово!");
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(initReplyMarkupB());
        return sendMessage;
    }

    public static ReplyKeyboardMarkup initReplyMarkupA() {
        ReplyKeyboardMarkup keyboardMarkup = replyKeyboardMarkupBuilder();
        keyboardMarkup.setIsPersistent(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);

        keyboardRow.add(new KeyboardButton("Нет такого документа (завершить)"));

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup initReplyMarkupB() {
        ReplyKeyboardMarkup keyboardMarkup = replyKeyboardMarkupBuilder();
        keyboardMarkup.setIsPersistent(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);

        keyboardRow.add(new KeyboardButton("Вернуться назад"));

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }
}
