package org.example;

import com.github.lalyos.jfiglet.FigletFont;
import org.example.contract.wrappers.JavaToken;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;

public class Deploy {
  public static int deploy(Web3j web3j) throws Exception {
    System.out.println("Deploying on Goerli... ");
    JavaToken javaToken = JavaToken.deploy(web3j, Credentials.create(EnvVar.GOERLI_PRIVATE_KEY), new DefaultGasProvider()).send();
    System.out.println(FigletFont.convertOneLine("Success!"));
    System.out.println("Deployed at: ");
    System.out.println("https://goerli.etherscan.io/address/"+javaToken.getContractAddress());
    System.out.println(javaToken.getTransactionReceipt());
    return 0;
  }
}
