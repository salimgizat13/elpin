package com.telegrambot.project.bankruptcy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public static ReplyKeyboardMarkup replyKeyboardMarkupBuilder() {
		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
		keyboardMarkup.setResizeKeyboard(true); //подгоняем размер
		keyboardMarkup.setOneTimeKeyboard(true); //скрываем после использования
		return keyboardMarkup;
	}

	public static ReplyKeyboardMarkup defaultButton() {
		ReplyKeyboardMarkup keyboardMarkup = replyKeyboardMarkupBuilder();

		List<KeyboardRow> keyboardRows = new ArrayList<>();

		KeyboardRow keyboardRow = new KeyboardRow();
		keyboardRows.add(keyboardRow);

		keyboardRow.add(new KeyboardButton("Вернуться назад"));

		keyboardMarkup.setKeyboard(keyboardRows);
		return keyboardMarkup;
	}

}
