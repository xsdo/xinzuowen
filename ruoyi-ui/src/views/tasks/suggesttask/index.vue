<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否使用" prop="isUsed">
        <el-input
          v-model="queryParams.isUsed"
          placeholder="请输入是否使用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作文id" prop="compositionId">
        <el-input
          v-model="queryParams.compositionId"
          placeholder="请输入作文id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作文名" prop="comName">
        <el-input
          v-model="queryParams.comName"
          placeholder="请输入作文名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="点赞数" prop="comLikes">
        <el-input
          v-model="queryParams.comLikes"
          placeholder="请输入点赞数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评论数" prop="comDiscuss">
        <el-input
          v-model="queryParams.comDiscuss"
          placeholder="请输入评论数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否置顶" prop="tTop">
        <el-input
          v-model="queryParams.tTop"
          placeholder="请输入是否置顶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="置顶结束时间" prop="tEndtime">
        <el-date-picker clearable
          v-model="queryParams.tEndtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择置顶结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['tasks:suggesttask:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['tasks:suggesttask:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['tasks:suggesttask:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tasks:suggesttask:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="suggesttaskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="是否使用" align="center" prop="isUsed" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="作文id" align="center" prop="compositionId" />
      <el-table-column label="作文类型" align="center" prop="compositionType" />
      <el-table-column label="作文名" align="center" prop="comName" />
      <el-table-column label="作文图" align="center" prop="comImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.comImage" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="点赞数" align="center" prop="comLikes" />
      <el-table-column label="评论数" align="center" prop="comDiscuss" />
      <el-table-column label="是否置顶" align="center" prop="tTop" />
      <el-table-column label="置顶结束时间" align="center" prop="tEndtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.tEndtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tasks:suggesttask:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tasks:suggesttask:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改推荐作文对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="是否使用" prop="isUsed">
          <el-input v-model="form.isUsed" placeholder="请输入是否使用" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="作文id" prop="compositionId">
          <el-input v-model="form.compositionId" placeholder="请输入作文id" />
        </el-form-item>
        <el-form-item label="作文名" prop="comName">
          <el-input v-model="form.comName" placeholder="请输入作文名" />
        </el-form-item>
        <el-form-item label="作文图" prop="comImage">
          <image-upload v-model="form.comImage"/>
        </el-form-item>
        <el-form-item label="点赞数" prop="comLikes">
          <el-input v-model="form.comLikes" placeholder="请输入点赞数" />
        </el-form-item>
        <el-form-item label="评论数" prop="comDiscuss">
          <el-input v-model="form.comDiscuss" placeholder="请输入评论数" />
        </el-form-item>
        <el-form-item label="是否置顶" prop="tTop">
          <el-input v-model="form.tTop" placeholder="请输入是否置顶" />
        </el-form-item>
        <el-form-item label="置顶结束时间" prop="tEndtime">
          <el-date-picker clearable
            v-model="form.tEndtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择置顶结束时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSuggesttask, getSuggesttask, delSuggesttask, addSuggesttask, updateSuggesttask } from "@/api/tasks/suggesttask";

export default {
  name: "Suggesttask",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 推荐作文表格数据
      suggesttaskList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        isUsed: null,
        remarks: null,
        compositionId: null,
        compositionType: null,
        comName: null,
        comImage: null,
        comLikes: null,
        comDiscuss: null,
        tTop: null,
        tEndtime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询推荐作文列表 */
    getList() {
      this.loading = true;
      listSuggesttask(this.queryParams).then(response => {
        this.suggesttaskList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        isUsed: null,
        createTime: null,
        updateTime: null,
        remarks: null,
        compositionId: null,
        compositionType: null,
        comName: null,
        comImage: null,
        comLikes: null,
        comDiscuss: null,
        tTop: null,
        tEndtime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加推荐作文";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSuggesttask(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改推荐作文";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSuggesttask(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSuggesttask(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除推荐作文编号为"' + ids + '"的数据项？').then(function() {
        return delSuggesttask(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tasks/suggesttask/export', {
        ...this.queryParams
      }, `suggesttask_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
