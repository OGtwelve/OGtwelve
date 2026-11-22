### Marshall Wang — `OGtwelve`

**Backend engineer.** I build the layer between a platform and the things it has to trust — identity, credentials, and access control.

Java / Spring Boot · TypeScript · AI agent infrastructure

---

#### 🔭 Now — enterprise AI coding-agent platform

Building the internal coding-agent platform at an energy company's AI lab. It routes across multiple model providers instead of locking into one vendor, and I own:

- **Client-to-runtime integration** — session lifecycle, streamed responses, tool-call round-trips, and reconnection when the agent runtime drops mid-session
- **LDAP-based enterprise SSO** — directory bind, group-to-role mapping, and a deprovisioning path that revokes on the *next request* rather than at token expiry
- **The admin console** — provider registration, credential configuration, and per-team usage visibility

---

#### 🤖 Agent infrastructure — [developerz.ai](https://developerz.ai)

**Agent orchestrator** — a Planner / Worker / Reviewer loop that turns a goal into merged pull requests. Published to npm and PyPI as two implementations, TypeScript and Python.
What I built in it: **provider-agnostic structured output** (which unblocked non-Claude models), **crash recovery** from persisted task state, and **git-safety guardrails** that bound what an autonomous loop can do to a working tree.
→ [my merged PRs](https://github.com/developerz-ai/ai-task-master/pulls?q=is%3Apr+author%3AOGtwelve+is%3Amerged)

**Evaluation harness** for an automated code-review platform — a reviewer benchmark with prompt A/B variants and finding-matching, plus a shadow pipeline scoring every review against a leading commercial reviewer on the same pull requests. The measurement it produced drove a roughly four-fold gain in unique findings.

**Scoped-token authorization** on an agent-economy payments platform — bounded grants for machine clients, with spend caps, short expiry, and cascading revocation, so an autonomous client acts under an auditable, revocable authority instead of a user's full credential.

---

#### 📱 Shipped solo

**[TripKit](https://apps.apple.com/us/app/tripkit-by-ogtwelve/id6762074289)** — an AI travel planner on the App Store. Product, backend, client and infrastructure, built and operated alone. Every model call routes through the backend, so the provider key never ships to a device and output is validated before the client sees it.

---

> Most of this work lives in private repositories. Backend is mine — I write it, test it, and debug it in production. **Frontend I ship AI-assisted**, and I'd rather say that than pretend otherwise.

---

📫 **ogtwelve@ogtwelve.com.cn**

[ogtwelve.com.cn](https://ogtwelve.com.cn) · [LinkedIn](https://www.linkedin.com/in/marshall-wang-og12/) · [StackOverflow](https://stackoverflow.com/users/15959331/ogtwelve) · [LeetCode](https://leetcode.cn/u/ogtwelve/)

<!---
OGtwelve/OGtwelve is a ✨ special ✨ repository because its `README.md` (this file) appears on your GitHub profile.
You can click the Preview link to take a look at your changes.
--->
