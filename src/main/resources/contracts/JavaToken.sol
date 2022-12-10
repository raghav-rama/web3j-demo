// SPDX-License-Identifier: MIT
pragma solidity ^0.8.9;

import "node_modules/@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "node_modules/@openzeppelin/contracts/access/Ownable.sol";
//import "../../../../../.m2/repository/org/webjars/npm/openzeppelin__contracts/4.4.1/openzeppelin__contracts-4.4.1.jar!/META-INF/resources/webjars/openzeppelin__contracts/4.4.1/access/Ownable.sol";
//import "../../../../../.m2/repository/org/webjars/npm/openzeppelin__contracts/4.4.1/openzeppelin__contracts-4.4.1.jar!/META-INF/resources/webjars/openzeppelin__contracts/4.4.1/token/ERC20/ERC20.sol";


contract JavaToken is ERC20, Ownable {
    constructor() ERC20("JavaToken", "JTK") {}

    function mint(address to, uint256 amount) public onlyOwner {
        _mint(to, amount);
    }
}