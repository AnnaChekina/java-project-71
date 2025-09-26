# Comparator

### Hexlet tests and linter status:
[![Actions Status](https://github.com/AnnaChekina/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/AnnaChekina/java-project-71/actions)
[![Java CI](https://github.com/AnnaChekina/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/AnnaChekina/java-project-71/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=AnnaChekina_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=AnnaChekina_java-project-71)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=AnnaChekina_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=AnnaChekina_java-project-71)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=AnnaChekina_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=AnnaChekina_java-project-71)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=AnnaChekina_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=AnnaChekina_java-project-71)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=AnnaChekina_java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=AnnaChekina_java-project-71)

CLI utility for finding differences between configuration files (JSON, YAML). Supports multiple output formats.

## Setup

```bash
make build
```

## Run

```bash
make run-dist ARGS="file1.json file2.json"
make run-dist ARGS="file1.yaml file2.yaml -f plain"
make run-dist ARGS="-h"  # Show help
```

## Run tests

```bash
make test
```

## Run checkstyle

```bash
make checkstyle
```

## Output Formats

* stylish - visual tree diff (default)
* plain - text descriptions
* json - structured data

[![asciicast](https://asciinema.org/a/PHABICjbZP1ATNcJo8vSDbv6I.svg)](https://asciinema.org/a/PHABICjbZP1ATNcJo8vSDbv6I)
