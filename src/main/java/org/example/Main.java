package org.example;

import com.github.lalyos.jfiglet.FigletFont;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.contract.wrappers.JavaToken;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

public class Main {


    public static void main (String[] args) throws Exception {

        Dotenv dotenv = Dotenv.load();
        final String ALCHEMY_API_URL=dotenv.get("ALCHEMY_API_URL");
        final String GOERLI_PRIVATE_KEY=dotenv.get("GOERLI_PRIVATE_KEY");

        System.out.println(FigletFont.convertOneLine("gm web3j"));
        System.out.println(FigletFont.convertOneLine("Mint ERC20 Tokens!"));

        Web3j web3j = Web3j.build(new HttpService(ALCHEMY_API_URL));

//        JavaToken javaToken = JavaToken.deploy(web3j, Credentials.create("your_private_key"), new DefaultGasProvider()).send();
//                .deploy(web3j, Credentials.create("your_private_key"), new DefaultGasProvider(), "Hello Blockchain World").send();
        JavaToken javaToken = JavaToken.load("0xC5890144C7a8fdCdC60e5117ec473B246F95299d", web3j, Credentials.create(GOERLI_PRIVATE_KEY), new DefaultGasProvider());
        String response_json = String.valueOf(javaToken.mint("0x2C1b291B3946e06ED41FB543B18a21558eBa3d62", BigInteger.valueOf(31782637126318731L)).send());
        System.out.println(response_json);
        web3j.shutdown();

    }
}