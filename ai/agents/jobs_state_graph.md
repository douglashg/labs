# State Graph - Hierarchical Flow

## State Graph Mermaid

```mermaid
stateDiagram-v2
    [*] --> CEO
    
    CEO --> CFO
    CEO --> CISO
    CEO --> CMO
    CEO --> COO
    CEO --> CTO
    CEO --> HR
    CEO --> Legal
    CEO --> Managers
    
    CFO --> Accountant
    CFO --> Auditor
    CFO --> Billing
    CFO --> Treasurer
    
    CISO --> AppSec
    CISO --> GRC
    CISO --> IAM
    CISO --> SOC
    CISO --> ThreatIntel
    
    SOC --> Teams
    Teams --> Blue
    Teams --> Purple
    Teams --> Red
    
    CMO --> Copywriter
    CMO --> CreativeDesigner
    CMO --> Growth
    CMO --> SEO
    CMO --> TrafficManager
    
    Growth --> GrowthAnalyst
    Growth --> GrowthHacker
    
    COO --> Operations
    Operations --> Data
    Operations --> Devops
    Operations --> Infra
    
    Data --> BI
    Data --> Engineering
    
    BI --> BIAnalyst
    BI --> BIReporting
    
    Engineering --> Engineer
    Engineering --> LLMops
    Engineering --> Mlops
    Engineering --> Pipelines
    Engineering --> Scientist
    
    CTO --> Head
    CTO --> TechLead
    
    Head --> Architect
    Head --> SM
    Head --> Squads
    
    SM --> Confluence
    SM --> Jira
    
    Squads --> DBA
    Squads --> Dev
    Squads --> Engineer
    Squads --> QA
    Squads --> TechLeadSquad
    
    Dev --> AI
    Dev --> Backend
    Dev --> Frontend
    Dev --> Fullstack
    
    Backend --> Java
    Backend --> Python
    Backend --> Rust
    
    Java --> Helidon
    Java --> Quarkus
    Java --> Spring
    
    Frontend --> Android
    Frontend --> Angular
    Frontend --> IOS
    
    QA --> Testers
    
    HR --> Allocator
    HR --> Evaluator
    HR --> Recruiter
    HR --> Trainer
    
    Legal --> Compliance
    
    Managers --> PM
    
    PM --> BA
    PM --> Designers
    PM --> PO
    
    Designers --> CopywriterDesign
    Designers --> UI
    Designers --> UX
    
    Customers --> CEO
    Shareholders --> CEO
    Stakeholders --> CEO
```

## Fluxo Hierárquico Descrição

1. **Nível C-Level (CEO)**: O CEO está no topo da hierarquia, reportando diretamente aos Shareholders e interagindo com Stakeholders e Customers.
2. **Diretorias (CFO, CISO, CMO, COO, CTO, HR, Legal, Managers)**: Todas as diretorias reportam ao CEO.
3. **Subdivisões por Diretoria**:
   - **CFO**: Accountant, Auditor, Billing, Treasurer
   - **CISO**: AppSec, GRC, IAM, SOC (com Teams: Blue, Purple, Red), ThreatIntel
   - **CMO**: Copywriter, CreativeDesigner, Growth (com GrowthAnalyst, GrowthHacker), SEO, TrafficManager
   - **COO**: Operations (com Data, Devops, Infra), onde Data se divide em BI (BIAnalyst, BIReporting) e Engineering (Engineer, LLMops, Mlops, Pipelines, Scientist)
   - **CTO**: Head (com Architect, SM, Squads), onde SM gerencia Confluence e Jira, e Squads gerencia DBA, Dev (com AI, Backend, Frontend, Fullstack), Engineer, QA (com Testers), TechLeadSquad
   - **HR**: Allocator, Evaluator, Recruiter, Trainer
   - **Legal**: Compliance
   - **Managers**: PM (com BA, Designers, PO), onde Designers se divide em CopywriterDesign, UI, UX
