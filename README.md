# Enhanced Charles
 The working base of a module injector/patcher for Java built apps

The few modules already implemented are designated to work on Charles 4.6.2, but the key process works on any version/any Java-built app, aslong as the modules you implement follow the said version/app logic.

Made this essentially for myself to improve Charles by adding new features and fix bugs that bothered me, but thought this might be helpful to someone at some point.

# Default Transformers

## Context Transformer

Patches the context menu appearing when you right click on a request and adds:
- `Copy Loli Script` feature which converts the request to a properly built [Loli Script](https://openbullet.github.io/stacker.html#loliscript)
- `Copy Header Keys` feature which copies all the headers names in clipboard

![enter image description here](https://i.imgur.com/aEzAB6K.png)

## Demo Transformer

- Removed the trial runner that would make the app exit after 30 minutes
- Removed the shareware reminder causing an unnecessary delay at startup

### JA3 Transformer

Patches the overview of a request to add a "JA3" node which displays:

- The plain and hashed [JA3](https://github.com/salesforce/ja3) of the request
- The common app/device that matches this JA3 

![enter image description here](https://i.imgur.com/gAmuVIn.png)

**Common JA3s** (*used for the identification*)

| JA3  | App  
|---|---|
| `b32309a26951912be7dba376398abc3b` | Chrome 83+ | 
| `66918128f1b9b03303d77c6f2eefd128` | Chrome 72 | 
| `b4918ee98d0f0deb4e48563ca749ef10` | Chrome 70 | 
| `bc6c386f480ee97b9d9e52d472b772d8` | Chrome 62  | 
| `aa7744226c695c0b2e440419848cf700` | Firefox 88 | 
| `b20b44b18b853ef29ab773e921b03422` | Firefox 63  | 
| `0ffee3ba8e615ad22535e7f771690a28` | Firefox 56  | 
| `656b9a2f4de6ed4909e157482860ab3d` | iOS 14.0  | 
| `6fa3244afc6bb6f9fad207b6b52af26b` | iOS 13.0  | 
| `5c118da645babe52f060d0754256a73c` | iOS 12.1  | 
| `a69708a64f853c3bcc214c2c5faf84f3` | iOS 11.1  |