# Spring 面试宝典（结合本仓库）

## 1. 高频总览

- IoC / DI 是什么，Bean 生命周期如何。
- AOP 原理（JDK 动态代理 vs CGLIB），应用场景。
- Spring MVC 请求处理流程。
- 事务传播与隔离级别。
- Spring 5 -> 6 核心变化（Java 17、Jakarta）。

---

## 2. IoC / DI 必答

### Q1：什么是 IoC？
**答法要点**：控制权反转，Bean 的创建与组装从业务代码移交容器，降低耦合。

### Q2：BeanFactory 和 ApplicationContext 区别？
- `BeanFactory`：基础容器，按需加载。
- `ApplicationContext`：功能更全（国际化、事件机制、AOP 集成等），项目里更常用。

### Q3：依赖注入方式？
- 构造器注入（推荐，利于不可变）。
- setter 注入。
- 注解注入（`@Autowired` / `@Resource`）。

---

## 3. AOP 高频

### Q1：Spring AOP 默认是编译期织入吗？
不是，默认是运行期代理。

### Q2：JDK 动态代理和 CGLIB 区别？
- JDK：基于接口。
- CGLIB：基于继承生成子类。

### Q3：常见通知类型？
前置、后置、返回、异常、环绕。

---

## 4. Spring MVC 高频

### Q1：一次请求的核心流程？
`DispatcherServlet` -> `HandlerMapping` -> `HandlerAdapter` -> Controller -> `ViewResolver` -> 视图渲染/响应。

### Q2：`@Controller` 和 `@RestController` 区别？
- `@Controller`：通常返回视图。
- `@RestController`：返回 JSON（`@Controller + @ResponseBody`）。

### Q3：参数绑定常见注解？
`@RequestParam`、`@PathVariable`、`@RequestBody`、`@ModelAttribute`。

---

## 5. 事务与数据库

### Q1：`@Transactional` 失效常见场景？
- 同类内部自调用。
- 方法不是 `public`。
- 异常被吃掉且未回滚。
- 没有被 Spring 管理。

### Q2：传播行为最常问哪些？
- REQUIRED（默认）
- REQUIRES_NEW
- SUPPORTS

---

## 6. Spring 6 / Java 17 升级面试题

### Q1：为什么 Spring 6 要求 Java 17？
因为框架基线升级，利用新版本 JDK 的长期支持能力及语言/运行时改进。

### Q2：Jakarta 迁移核心点？
`javax.*` -> `jakarta.*`，尤其是 Servlet、Annotation、Validation、JPA 等包名变化。

### Q3：老项目升级最容易踩坑在哪？
- 依赖冲突（旧 `javax` 与新 `jakarta` 混用）。
- 容器版本不匹配（Tomcat 9 vs 10+）。
- 测试框架与插件版本过老。

---

## 7. 项目结合答题模板（可直接背）

> “我在一个 Spring Demo 多模块项目里做过从 Spring 5 到 Spring 6 的升级。核心工作包括：
> 1）Java 基线升级到 17；
> 2）`javax` 注解迁移到 `jakarta`；
> 3）Servlet API 与 web.xml schema 对齐 Jakarta 规范；
> 4）测试从 JUnit4 迁移到 JUnit5；
> 5）补充了学习指南和面试知识整理文档，方便新人快速上手和复习。”

