struct abc {
	int one;
	int two;
	long three;
};

void print_i32(int);
void print_i64(long);

int main() {
	struct abc instance;
	instance.one = 1;
	instance.two = 2;
	instance.three = 3;
	print_i32(instance.one);
	print_i32(instance.two);
	print_i64(instance.three);
	return 0;
}