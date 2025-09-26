build:
	make -C app build

run-dist:
	make -C app run-dist ARGS="$(ARGS)"

report:
	make -C app report

test:
	make -C app test

checkstyle:
	make -C app checkstyle
