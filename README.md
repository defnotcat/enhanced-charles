# Enhanced Charles
 The working base of a module injector/patcher for Java built apps

The few modules already implemented are designated to work on Charles 4.6.1, but the key process works on any version/any Java-built app, aslong as the modules you implement follow the said version/app logic.

Made this essentially for myself to improve Charles by adding new features and fix bugs that bothered me, but thought this might be helpful to someone at some point.

# Default Transformers

## Context Transformer

Patches the context menu appearing when you right click on a request and add new the `Copy Loli Script` feature which converts the request to a properly built [Loli Script](https://openbullet.github.io/stacker.html#loliscript)

![enter image description here](https://i.imgur.com/7HfGtvm.png)

## Demo Transformer

Patches the trial runner that would make the app exit after 30 minutes of unregistered usage

## Header Order Transformer

Fixes a "bug" that alterates the header order of request modified through Charles breakpoints if the request has the `Content-Length` header by systematically putting it at the end of the list

### JA3 Transformer

Patches the overview of a request and add a "JA3" node which displays the plain and hashed [JA3](https://github.com/salesforce/ja3) of the request (*before Charles alterates it*)

![enter image description here](https://i.imgur.com/RDDD94s.png)
