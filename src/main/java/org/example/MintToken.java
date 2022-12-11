package org.example;

import com.github.lalyos.jfiglet.FigletFont;
import org.example.contract.wrappers.JavaToken;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

import static org.example.EnvVar.GOERLI_PRIVATE_KEY;

public class MintToken {
  public static int mint(Web3j web3j) throws Exception {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter contract address: ");
    String contractAddress = sc.next();
    System.out.println("To which address do you want to mint?");
    String to = sc.next();
    System.out.println("How may tokens do you want to mint?");
    BigInteger amt = BigInteger.ZERO;
    try {
      String _amt = sc.next();
      amt = new BigInteger(_amt);
      amt = amt.multiply(new BigInteger("1000000000000000000"));
    } catch (NumberFormatException nfe) {
      System.out.println("Couldn't mint, bad number");
      System.exit(1);
    } catch (Exception e) {
      System.out.println("Couldn't mint unknown error occurred");
      System.exit(1);
    }

    JavaToken javaToken = JavaToken.load(contractAddress , web3j, Credentials.create(GOERLI_PRIVATE_KEY), new DefaultGasProvider());
    String response_json = String.valueOf(javaToken.mint(to, amt).send());

    String transactionHash = response_json.split(",")[0].split("=")[1];
    transactionHash = transactionHash.substring(1,67);

    System.out.println(FigletFont.convertOneLine("Success!"));
    System.out.println("JavaToken JKT minted successfully, view transaction here: ");
    System.out.println("https://goerli.etherscan.io/tx/"+transactionHash);
    return 0;
  }
}

// 0xC5890144C7a8fdCdC60e5117ec473B246F95299d
// 0x2C1b291B3946e06ED41FB543B18a21558eBa3d62