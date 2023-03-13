import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productEdit: Product = null;
  productEditForm: FormGroup;
  id: number;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.id = +paraMap.get('id');
      this.productEdit = this.productService.findById(this.id);
    });
    this.productEditForm = new FormGroup({
      id: new FormControl(this.productEdit.id, [Validators.required]),
      name: new FormControl(this.productEdit.name, [Validators.required]),
      price: new FormControl(this.productEdit.price, [Validators.required]),
      description: new FormControl(this.productEdit.description, [Validators.required]),
    });
  }

  onEdit() {
    this.productService.update(this.id, this.productEditForm.value);
    this.router.navigateByUrl('/product');
  }
}
