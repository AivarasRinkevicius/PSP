# Užduotis 1.3 Bibliotekos panaudojimas

* Pagal gautą validatorių biblioteką esančia to žmogaus folderyje `My_Implementation/Validators` (https://git.mif.vu.lt/aule6352/psp_2021_1) importavau JAR failą į savo aplikaciją ir sukūriau vartotojo kūrimo modulį.
* Yra front-end ir back-end dalys, kuriame palaikomos visos operacijos gavimas, trinimas, redagavimas ir ištrinimas pagal userId.
* Paleidus Spring Boot serverį front-end'ą galima pasiekti adresu `http://localhost:8080/`
* Aprašyti testai service (modulio) ir controller klasėms.
* Panaudota H2 duombazė, front-end'ui JSP taip pat naudotasi Spring Boot back-end'ui. 
* Įgyvendintas factory pattern'as, gautos validatorių klasės yra apgaubtos(wrapped). Visa tai daryta norint sumažinti priklausomybė nuo duotos bibliotekos ir kad lengviau būtų įią aplikaciją praplėsti.

## Created by: Aivaras Rinkevičius 4 grupė 2 pogrupis programų sistemų
