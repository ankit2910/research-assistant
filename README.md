# Research Assistant — AI-Powered Chrome Extension

A Chrome extension that lets you select any text on a webpage and instantly get an AI-generated summary, powered by Google's Gemini API and a Spring Boot backend.

## Features

- **Summarize** — select any text on a webpage and get a concise AI-generated summary in a side panel
- **Research Notes** — save and persist personal notes locally within the extension, independent of the AI features
- Built on **Manifest V3** using Chrome's side panel API for a persistent, non-intrusive UI

## Architecture
Chrome Extension (Manifest V3)
│ user selects text → clicks action button
▼
Content Script (executeScript) — captures selected text
▼
Side Panel (HTML/CSS/JS) — sends request to backend
▼
Spring Boot REST API (/api/research/process)
│ builds prompt based on operation type
▼
Google Gemini API — generates response
▼
Backend parses response → returns to extension
▼
Side Panel renders result to user


## Tech Stack

**Backend:**
- Java, Spring Boot
- Spring WebFlux (`WebClient`) for reactive, non-blocking HTTP calls to Gemini
- Jackson for JSON serialization/deserialization
- Lombok for boilerplate reduction

**Extension:**
- Chrome Extension Manifest V3
- Vanilla JavaScript, HTML, CSS
- Chrome APIs: `chrome.scripting`, `chrome.storage`, `chrome.sidePanel`

**External API:**
- Google Gemini API for text summarization and topic suggestion

## API Endpoints

### `POST /api/research/process`

Processes selected text using the specified AI operation.

**Request body:**
```json
{
  "content": "The text you want to process",
  "operation": "summarize"
}
```

`operation` accepts:
- `summarize` — returns a concise summary of the content
