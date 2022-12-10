package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvVar {
  static Dotenv dotenv = Dotenv.load();
  final static String ALCHEMY_API_URL=dotenv.get("ALCHEMY_API_URL");
  final static String GOERLI_PRIVATE_KEY=dotenv.get("GOERLI_PRIVATE_KEY");

}
