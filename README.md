
<p align="center">
<img src="https://user-images.githubusercontent.com/99259327/187318644-d6e53541-e582-4f90-81be-aa24393a72b3.png" width="300" />
<p>

# <h1 align="center"> *Maestro:* **Projeto engenharia de software II** </h1>
# <h1 align="center"> Membros do grupo: </h1>
Evandro Rodrigues Tiburcio - 0030481921018

Gabriel Leite Cardoso - 0030482121018

Guilherme Kohler Campos Salla - 0030482121004

Lucas José Marcondes Rossi - 0030482121023

Regiane Corrêa de Lara - 0030482121012

# <h1 align="center"> Resumo:

<p text-align: justify>
	<p>
	O projeto Maestro será um conjunto de micros serviços que realizarão a gestão de controle de acesso dos seguimentos de portaria, sendo a orgânica (com atendente in loco - "PO") ou eletrônica (remota - "PR" ou virtual - "PV"). Desses seguimentos, o projeto terá maior ênfase no sistema de portaria remota, sendo esse um nicho de mercado onde não há a presença física de um operador de controle de acesso no cliente, porém, existem vários operadores (para um mesmo cliente) em uma central de operações monitorando a portaria desse cliente a distância.

#### Os objetivos iniciais são:
* Melhorar a qualidade dos atendimentos, evitando falhas operacionas;
* Melhorar a produtividade da equipe;
* Fornecer relátorios estratégicos para tomada de decisões para os gestores.
	
#### Telas fundamentais:
- Tela de gerenciamento de Pessoas;
- Tela de gerenciamento de tipos de Pessoas (Proprietários, Moradores, Visitantes, Visitantes com Pré-autorização, Prestadores de Serviços e Prestadores de Serviço com Pré-autorização);
- Tela de gerenciamento das regras de acesso de cada local/cliente;
- Tela de gerenciamento dos dispositivos de controle de acesso, VoIp e CTFV de cada cliente;
- Tela de atendimento operacional (PO e PR).

	<p>
	O sistema irá contar com uma tela para cadastro de pessoas, possuindo o "tipo de pessoa" que seria uma identificação para diferenciar se a pessoa em questão é um morador, prestador de serviço, visitante, etc. O sistema também contará com a tela principal de utilização, em que haverá grande interação do atendente com o sistema, ou seja, por onde ele realizará os atendimentos remotos com o usuário e controlará equipamentos diversos, utilizando comandos chave. Contudo, será capaz de controlar a abertura de portões, permitindo assim, a entrada e saída de pessoas, onde será feita identificação e prosseguindo com a liberação (ou não) do usuário que pretende adentrar no condomínio. Esta tela será o nosso principal foco no projeto.
	<p>
	
	Um dos pilares do nosso projeto é fazer a integração dos equipamentos, baixar os comandos, o sistema deverá possuir comunicação via voip, ele será software externo, pois conseguimos ter integração mais rápida, que se encaixa em micro serviços. Em qualquer um dos segmentos estes dispositivos fornecem comunicação com os atendentes (sendo possível utilização de equipamento externo ou em um módulo do APP). É obrigatório link de internet de aproximadamente 50 Kbps de up/down por equipamento de voz simultâneo. 
	<p>
	
	O projeto Maestro tem como finalidade atender uma parcela do mercado de segurança patrimonial, nos segmentos de portaria convencional (portaria orgânica - atendimento in-loco; "PO"), portaria remota (atendente dentro de uma base operacional; "PR") e portaria virtual (sem interação de atendente, ou somente exceções; "PV").
	<p>
	
	Para atingir esse objetivo é necessário o controle de acesso de pessoas subdivididas nos principais tipos: proprietários (que não residem no local), moradores, visitantes, visitantes com pré-autorização, prestadores de serviços e prestadores de serviço com pré-autorização.
Em qualquer dos segmentos é necessário a adequação tecnológica dos clientes que optarem por esse serviço. Dentro as necessidades (in-loco) seguem:
Módulo de controle de acesso: Em qualquer um dos segmentos esse item funciona no formato stand-alone, ou seja, não há necessidade de liberação por software central para usuários que detenham algum tipo de dispositivo já autorizado para acesso no local. Em caso de falha de comunicação com os demais sistemas esses usuário continuam tendo acesso aos locais previamente autorizados pelos seus dispositivos. Para integração com APP é necessário link de internet com banda de aproximadamente 100 kbps up/down.
	<p>
	
	Sistema de CFTV: Nos segmentos de PO e PR esses dispositivos são utilizados para auxílio no cadastro e identificação de pessoas e para acompanhamento de quaisquer eventos pertinentes ao local. No segmento de PV é utilizado para tomada de decisões e gatilhos para geração de eventos. Esses dispositivos variam o consumo de banda de 250 ~ 1500 kbps de up e 400 kbps de download.
	<p>

 Estrutura:
	Cloud (a definir)
<p>

# Tecnologias e ferramentas utilizadas para o desenvolvimento do sistema:

- Java + Spring Framework (backend);
- MariaDB (banco de dados);
- JavaScript;
- React JS (html/css); 
- Figma;
- Visual Studio Code;
- Visual Code;
- Versionamento de código pelo GitHub;
- VM para testes iniciais (Oracle VBOX - Debian 11)
