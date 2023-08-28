package com.telegrambot.project.bankruptcy.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public interface Actions {
    BotApiMethod handle(Update update);

    BotApiMethod callback(Update update);
}
