package com.telegrambot.project.bankruptcy.service;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import static com.telegrambot.project.bankruptcy.Application.defaultButton;

public class QuestionToLawyerAction implements Actions {

    public final String action;

    public QuestionToLawyerAction(String action) {
        this.action = action;
    }

    @Override
    public BotApiMethod handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = "В свободной изложите свой вопрос";
        return new SendMessage(chatId, text);
    }

    @Override
    public BotApiMethod callback(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String username = update.getMessage().getChat().getFirstName();
        String text = String.format("%s, Спасибо за Ваше обращение! Юристы уже решают Вашу проблему и " +
                "в ближайшее время свяжутся с вами", username);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(initKeyBoard());
        return sendMessage;
    }

    public static ReplyKeyboardMarkup initKeyBoard() {
        return defaultButton();
    }
}
