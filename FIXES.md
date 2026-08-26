# SkillGraph AI - fixes applied

## Frontend
- Fixed the missing Angular service/model/layout import structure.
- Resume upload now has a real file picker, drag/drop, validation, loading state and backend upload.
- Backend analysis is stored in sessionStorage so refreshing a page does not immediately empty the dashboard.
- Dashboard, Skill Graph, Learning Roadmap, Company Matching, AI Recommendations and Interview Readiness now consume the actual resume-analysis response instead of only static demo values.
- GitHub Analysis now calls `GET /api/github/{username}`.
- Profile now loads/saves data through `/api/profile`.
- Register now creates a profile through `/api/profile`.
- Login now calls the existing backend demo authentication endpoint.
- Added a mobile sidebar toggle and responsive global layout rules.

## Backend
- Seeded the `company_skill` dataset on first startup so company matching has real rows to compare against.
- Matching now uses the skills stored in MySQL instead of temporary hardcoded resume skills.
- Resume score and best company/match score are calculated from the extracted result instead of fixed 80/82 values.
- Company matching is case-insensitive.
- Local API CORS supports both localhost:4200 and 127.0.0.1:4200.
- Local demo API endpoints are permitted by Spring Security because the project does not currently have a complete JWT request filter.

## Validation
- TypeScript compiler check passed with the project's TypeScript compiler.
- Full Angular CLI build could not be executed in this environment because the bundled Angular CLI requires Node >= 22.22.3 while this environment has Node 22.16.0.
- Maven build could not be executed here because Maven is not installed and the wrapper cannot download Maven in this sandbox.
