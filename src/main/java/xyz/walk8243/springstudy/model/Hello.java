package xyz.walk8243.springstudy.model;

import xyz.walk8243.springstudy.model.constant.Environment;

public record Hello(
	String str,
	Environment env
) {}
