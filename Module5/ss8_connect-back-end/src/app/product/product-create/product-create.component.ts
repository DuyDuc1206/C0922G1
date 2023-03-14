import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categories: Category[] = [];

  productCreateForm: FormGroup;

  constructor(private productService: ProductService,
              private router: Router,
              private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.productCreateForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      price: new FormControl(),
      description: new FormControl(),
      category: new FormControl(this.categories)
    });
    this.getAllCategory();
  }

  onSubmit() {
    const product = this.productCreateForm.value;
    this.productService.createProduct(product).subscribe(item => {
      this.router.navigateByUrl('/product');
    });
  }

  getAllCategory() {
    this.categoryService.getAll().subscribe(item => {
      this.categories = item;
    });
  }
}
