package org.example;

import com.github.lalyos.jfiglet.FigletFont;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import static org.example.EnvVar.ALCHEMY_API_URL;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws Exception {
        System.out.println(FigletFont.convertOneLine("gm web3j"));
        System.out.println(FigletFont.convertOneLine("Mint ERC20 Tokens!"));

        Web3j web3j = Web3j.build(new HttpService(ALCHEMY_API_URL));

        System.out.println("Welcome to JavaToken (JTK) Minter: ");
        System.out.println("1. Deploy your own JTK contract");
        System.out.println("2. Mint some JavaTokens");

        Scanner sc = new Scanner(System.in);
        byte choice = sc.nextByte();

        switch (choice) {
            case 1: Deploy.deploy(web3j);
            break;
            case 2: MintToken.mint(web3j);
            break;
        }
        web3j.shutdown();
    }
}