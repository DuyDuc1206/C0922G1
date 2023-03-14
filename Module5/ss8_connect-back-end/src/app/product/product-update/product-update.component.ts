import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../service/category.service';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productEditForm: FormGroup;
  categories: Category[] = [];
  id: number;

  constructor(private categoryService: CategoryService,
              private productService: ProductService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.id = +paraMap.get('id');
      this.getProduct(this.id);
    });
    this.getCategory();
  }

  getProduct(id: number) {
    this.productService.findById(id).subscribe(product => {
      this.productEditForm = new FormGroup({
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description),
        category: new FormControl(product.category),
      });
    });
  }

  onSubmit() {
    const product = this.productEditForm.value;
    this.productService.editProduct(this.id, product).subscribe(next => {
      this.router.navigateByUrl('product');
    });
  }

  getCategory() {
    this.categoryService.getAll().subscribe(item => {
      this.categories = item;
    });
  }
}
