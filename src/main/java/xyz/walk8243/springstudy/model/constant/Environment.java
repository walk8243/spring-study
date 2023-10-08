package xyz.walk8243.springstudy.model.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Environment {
	LOCAL("ローカル環境"),
	SANDBOX("一時的な開発環境"),
	DEVELOPMENT("開発環境"),
	STAGING("検証用の本番相当環境"),
	PRODUCTION("公開可能な本番環境");

	@Getter private final String description;

	public boolean isOpen() {
		return this.equals(DEVELOPMENT) || this.equals(PRODUCTION);
	}
}
