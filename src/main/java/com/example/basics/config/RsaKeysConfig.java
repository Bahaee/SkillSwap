package com.example.basics.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rsa") // va vers le fichier properties et recupère les propriétés qui commence par rsa
public record RsaKeysConfig(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}
