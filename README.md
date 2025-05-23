# NutriFácil

<img src="https://i.imgur.com/4uuO8th.png" alt="Página inicial do NutriFácil" style="max-width: 600px; border-radius: 16px; margin-bottom: 24px;">

---

## 🥗 Sobre o Projeto

O **NutriFácil** é um sistema simples, intuitivo e responsivo que ajuda pessoas a calcularem seu IMC, TMB, consumo de água e obterem recomendações alimentares de acordo com suas necessidades e restrições.  
Desenvolvido como trabalho acadêmico, utiliza backend em Java (Spring Boot) e frontend em Next.js com TailwindCSS e shadcn/ui.

---

## 🚀 Funcionalidades

- **Cálculo de IMC:** com classificação do resultado.
- **Cálculo de TMB:** baseado na fórmula de Harris-Benedict para ambos os sexos.
- **Consumo diário de água:** recomendação baseada no peso.
- **Recomendação alimentar personalizada:** selecionando tipo de dieta e restrições alimentares.

---

## 🚀 Como rodar o projeto

1. **Clone o repositório**
```bash
   git clone https://github.com/seuusuario/nutrifacil-backend.git
   cd nutrifacil-backend
```

2. Compile e rode
```bash
  ./mvnw spring-boot:run
```
Ou use sua IDE preferida (IntelliJ, Eclipse, VS Code).

3. Acesse a API

- Base URL: http://localhost:8080/api/

---

## 🔗 Endpoints
📏 IMC
- POST /api/imc/calcular

- Body:
```bash
  { "peso": 70, "altura": 1.75 }
```
- Resposta:
```bash
  { "imc": 22.86, "classificacao": "Peso normal" }
```

---

🔥 TMB
- POST /api/tmb/calcular

- Body:
```bash
  { "peso": 70, "altura": 175, "idade": 25, "sexo": "M" }
```

- Resposta:
```bash
  { "tmb": 1766.91 }
```

---

💧 Consumo de Água
- POST /api/agua/calcular

- Body:
```bash
  { "peso": 70 }
```

- Resposta:
```bash
  { "litrosPorDia": 2.45 }
```

---

🥗 Recomendações de Dieta
- POST /api/dieta/recomendar

- Body:
```bash
  {
  "tipoDieta": "lowcarb",
  "restricoes": ["nozes", "frango"]
}
```

- Resposta:
```bash
  {
  "recomendacoes": [
    "Ovos",
    "Abacate",
    "Folhas verdes"
  ]
}
```

---

### 🧪 Testes
Para rodar os testes automatizados:
```bash
./mvnw test
```
Todos os serviços principais possuem testes unitários cobrindo cálculos e regras de negócio.

---

## 💡 Tecnologias utilizadas

- **Backend:**  
  - Java 17+
  - Spring Boot 3.x
  - Maven
  - JUnit 5

- **Frontend:**  
  - Next.js 14
  - TailwindCSS
  - shadcn/ui
  - Axios
  - TypeScript

---

## 📝 Licença
Este projeto é acadêmico, para fins de estudo, sem fins comerciais.

---

## ✍️ Autores
- Lucas Marques
- Gabriel
- Wesley
- William

