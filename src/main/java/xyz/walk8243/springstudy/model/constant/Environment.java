package xyz.walk8243.springstudy.model.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Environment {
  LOCAL("ローカル環境", "local"),
  SANDBOX("一時的な開発環境", "sandbox"),
  DEVELOPMENT("開発環境", "dev"),
  STAGING("検証用の本番相当環境", "stg"),
  PRODUCTION("公開可能な本番環境", "prod");

  private final String description;
  private final String shortName;

  public boolean isOpen() {
    return this.equals(DEVELOPMENT) || this.equals(PRODUCTION);
  }
}
