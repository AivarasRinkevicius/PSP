## Created validators library based on the given unit tests from https://github.com/DeividasLT5/Projektavimas

All in all, tests cover all requirements for the given task. Code is readable.

However I would change some parts: 
* I would create the validator object in @BeforeEach method and there set up primary validation values for example: set up in PhoneValidatorTest valid country code, prefixes to change and length, in EmailValidatorTest set up the correct domain, banned symbols, and TLD lists, and in PasswordCheckerTest set up length and special symbols list. These values could be placed, either by using a constructor or by providing methods (seters). Now, I assumed what the default values should be from tests and task description. I hardcoded default values, and I also provided methods to set those values. If, for example, the user wants to add new validation rules for phone numbers - set new length, country code, prefix to change, or add new special symbols.
* I would add a new test that checks if the local part of the email does not exceed the maximum limit of 64 characters based on the email standard. However, in the given task's description, there was not explicitly asked to do it.

## Sukūrė: Aivaras Rinkevičius 4 grupė 2 pogrupis programų sistemų
