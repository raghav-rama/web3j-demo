# web3j-demo
This project uses [Web3j](https://docs.web3j.io/4.8.7/quickstart/) for deploying an ERC20 contract.

- clone repo and open in IntelliJ IDEA
- rename `.env_example` to `.env`
- add your Alchemy API URL and private key of your wallet account.
- make sure you have some gEth. If not get it from [here](https://goerlifaucet.com/)
- run `Main.java`

### Make your own smart contract Java Wrapper

- Install the solc compiler(see instructions [here](https://docs.soliditylang.org/en/latest/installing-solidity.html))
- Install all maven dependencies
- add your solidity file in `src/main/resources/contracts`
- run the maven goal `mvn web3j:generate-sources`
- copy/paste generated contract wrappers in `src/main/java/org/example/contract/wrappers`. This is not ideal, and can be avoided by making changes in the `pom.xml`
- now you can import the classes and call the contract functions!
 